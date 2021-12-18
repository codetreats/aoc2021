package net.codetreats.aoc2021.day18

import net.codetreats.aoc2021.day18.Tree.Companion.from
import net.codetreats.aoc2021.util.Level
import net.codetreats.aoc2021.util.Logger
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class TreeTest {
    private lateinit var classUnderTest : TreeTest

    @BeforeEach
    fun setup() {
        Logger.level = Level.INFO
        classUnderTest = TreeTest()
    }

    @Test
    fun simpleAdd() {
        assertEquals("[[[[[4,3],4],4],[7,[[8,4],9]]],[1,1]]", from("[[[[4,3],4],4],[7,[[8,4],9]]]").add(from("[1,1]"), false).toString())
        assertEquals("[[[[1,1],[2,2]],[3,3]],[4,4]]", from("[1,1]").add(from("[2,2]")).add(from("[3,3]")).add(from("[4,4]")))
        assertEquals("[[[[3,0],[5,3]],[4,4]],[5,5]]", from("[1,1]").add(from("[2,2]")).add(from("[3,3]")).add(from("[4,4]")).add(from("[5,5]")))
        assertEquals("[[[[5,0],[7,4]],[5,5]],[6,6]]", from("[1,1]").add(from("[2,2]")).add(from("[3,3]")).add(from("[4,4]")).add(from("[5,5]")).add(from("[6,6]")))
    }

    @Test
    fun complexAdd() {
        assertEquals("[[[[4,0],[5,4]],[[7,7],[6,0]]],[[8,[7,7]],[[7,9],[5,0]]]]", from("[[[0,[4,5]],[0,0]],[[[4,5],[2,6]],[9,5]]]").add(from("[7,[[[3,7],[4,3]],[[6,3],[8,8]]]]")))
    }

    @Test
    fun simpleReduce() {
        assertEquals("[[[[0,7],4],[[7,8],[6,0]]],[8,1]]", from("[[[[4,3],4],4],[7,[[8,4],9]]]").add(from("[1,1]")).reduce())
    }

    @Test
    fun simpleExplode() {
        assertEquals("[[[[0,9],2],3],4]", from("[[[[[9,8],1],2],3],4]").explode())
        assertEquals("[7,[6,[5,[7,0]]]]", from("[7,[6,[5,[4,[3,2]]]]]").explode())
        assertEquals("[[6,[5,[7,0]]],3]", from("[[6,[5,[4,[3,2]]]],1]").explode())
        assertEquals("[[3,[2,[8,0]]],[9,[5,[4,[3,2]]]]]", from("[[3,[2,[1,[7,3]]]],[6,[5,[4,[3,2]]]]]").explode())
        assertEquals("[[3,[2,[8,0]]],[9,[5,[7,0]]]]", from("[[3,[2,[8,0]]],[9,[5,[4,[3,2]]]]]").explode())
        assertEquals("[[[[4,0],[5,4]],[[0,[7,6]],[9,5]]],[7,[[[3,7],[4,3]],[[6,3],[8,8]]]]]", from("[[[[4,0],[5,0]],[[[4,5],[2,6]],[9,5]]],[7,[[[3,7],[4,3]],[[6,3],[8,8]]]]]").explode())
    }

    @Test
    fun simpleSplit() {
        assertEquals("[5,6]", Leaf(11).split())
        assertEquals("[6,6]", Leaf(12).split())
        assertEquals("[6,7]", Leaf(13).split())
        assertEquals("[7,7]", Leaf(14).split())
    }

    @Test
    fun simpleMagnitude() {
        assertEquals(143, from("[[1,2],[[3,4],5]]").magnitude())
        assertEquals(3488, from("[[[[8,7],[7,7]],[[8,6],[7,7]]],[[[0,7],[6,6]],[8,7]]]").magnitude())

    }

    fun assertEquals(expected: String, tree: Tree) = assertEquals(expected, tree.toString())
}