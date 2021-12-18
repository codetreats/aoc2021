package net.codetreats.aoc2021.day18

import net.codetreats.aoc2021.util.Logger
import kotlin.math.floor
import kotlin.math.ceil

sealed class Tree {
    val name = nextName()

    abstract fun magnitude(): Int
    abstract fun split(): Tree
    abstract fun graph(): Set<String>
    abstract fun addLeft(left: Int): Tree
    abstract fun addRight(right: Int): Tree

    fun add(tree: Tree, reduce: Boolean = true): Tree {
        val added = Node(this, tree)
        return if (reduce) added.reduce() else added
    }

    fun reduce(): Tree {
        var tree = this
        do {
            var oldTree = tree
            tree = tree.explode()
            if (tree != oldTree) {
                logger.debug("Tree exploded to: $tree")
                continue
            }
            tree = tree.split()
            if (tree != oldTree) {
                logger.debug("Tree splitted to: $tree")
                continue
            }
        } while (tree != oldTree)
        return tree
    }

    fun printGraph(): Tree {
        logger.info("Graph for $this")
        println("digraph G {")
        graph().forEach {
            println("  $it")
        }
        println("}")
        return this
    }

    companion object {
        val logger: Logger = Logger.forDay(18, Tree::class.java.simpleName)
        private var counter = 0
        fun nextName(): String = "NODE$counter++"

        fun from(str: String): Tree {
            if (!str.startsWith("[") && !str.endsWith("]")) {
                return Leaf(str.toInt())
            }
            val reduced = str.substring(1, str.length - 1)
            var opened = 0
            var i = 0
            do {
                if (reduced[i] == '[') {
                    opened++
                }
                if (reduced[i] == ']') {
                    opened--
                }
                i++
            } while (opened > 0)
            while (reduced[i] != ']' && reduced[i] != ',') {
                i++
            }
            return Node(from(reduced.substring(0, i)), from(reduced.substring(i + 1, reduced.length)))
        }
    }

    fun explode(): Tree = explode(0).tree

    private fun explode(level: Int): ExplodedTree {
        logger.debug("Check $name")
        if (this !is Node) {
            return ExplodedTree(this)
        }
        if (level == 4) {
            logger.debug("Explode $!")
            val left = this.left as Leaf
            val right = this.right as Leaf
            return ExplodedTree(Leaf(0), left.value, right.value)
        }
        logger.debug("Check left of $name")
        val leftExploded = left.explode(level + 1)
        if (leftExploded.tree != left) {
            logger.debug("Left of $name has been exploded ")
            return ExplodedTree(
                Node(leftExploded.tree, right.addLeft(leftExploded.right ?: 0)),
                leftExploded.left,
                null
            )
        }
        logger.debug("Check right of $name")
        val rightExploded = right.explode(level + 1)
        if (rightExploded.tree != right) {
            logger.debug("Right of $name has been exploded ")
            return ExplodedTree(
                Node(left.addRight(rightExploded.left ?: 0), rightExploded.tree),
                null,
                rightExploded.right
            )
        }
        return ExplodedTree(this)
    }
}

data class Leaf(val value: Int) : Tree() {
    override fun magnitude(): Int = value

    override fun toString() = "$value"

    override fun split(): Tree {
        if (value < 10) {
            return this
        }
        return Node(Leaf(floor(value / 2.0).toInt()), Leaf(ceil(value / 2.0).toInt()))
    }

    override fun graph() = setOf("$name [label = \"$value\"]")
    override fun addLeft(left: Int): Tree = Leaf(value + left)
    override fun addRight(right: Int) = Leaf(value + right)
}

data class Node(val left: Tree, val right: Tree) : Tree() {
    override fun magnitude(): Int = 3 * left.magnitude() + 2 * right.magnitude()

    override fun toString() ="[$left,$right]"

    override fun split(): Tree {
        if (left != left.split()) {
            return Node(left.split(), right)
        }
        return Node(left.split(), right.split())
    }

    override fun graph() = setOf("$name -> ${left.name}", "$name -> ${right.name}") + left.graph() + right.graph()
    override fun addLeft(left: Int) = Node(this.left.addLeft(left), right)
    override fun addRight(right: Int) = Node(left, this.right.addRight(right))
}

data class ExplodedTree(val tree: Tree, val left: Int? = null, val right: Int? = null)