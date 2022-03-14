package it.unibo.ise.lab.kr

import it.unibo.tuprolog.core.Atom
import it.unibo.tuprolog.core.Struct
import it.unibo.tuprolog.core.Term
import kotlin.test.Test
import kotlin.test.assertEquals

class TestHerbrandPeano {
    private val functors = arrayOf(
        Functor("a"),
        Functor("b"),
        Functor("f", 2)
    )

    private val peanoIntegers: Sequence<Term>
        get() = generateSequence<Struct>(Atom.of("z")) { Struct.of("s", it) }

    @Test
    fun testPartialHerbrandUniverse0() {
        assertEquals(
            herbrand(*functors, max = 0).toList(),
            peanoIntegers.take(1).toList()
        )
    }

    @Test
    fun testPartialHerbrandUniverse1() {
        assertEquals(
            herbrand(*functors, max = 1).toList(),
            peanoIntegers.take(2).toList()
        )
    }

    @Test
    fun testPartialHerbrandUniverse3() {
        assertEquals(
            herbrand(*functors, max = 2).map { println(it); it }.toList(),
            peanoIntegers.take(3).toList()
        )
    }
}