package com.example.myapplication.core

import org.junit.Assert
import org.junit.Test
import java.io.IOException
import java.lang.Exception

class AbstractTest {

    @Test
    fun test_success() {
        val dataObject = TestDataObject.Success("a", "b")
        val domainObject = dataObject.map(DataMapper.Base())

        Assert.assertTrue(domainObject is DomainObject.Success)
    }

    @Test
    fun test_fail() {
        val dataObject = TestDataObject.Fail(IOException())
        val domainObject = dataObject.map(DataMapper.Base())

        Assert.assertTrue(domainObject is DomainObject.Fail)
    }

    private sealed class TestDataObject : Abstract.Object<DomainObject, DataMapper>() {
        abstract override fun map(mapper: DataMapper): DomainObject

        class Success(
            private val oneString: String,
            private val twoString: String
        ) : TestDataObject() {
            override fun map(mapper: DataMapper): DomainObject {
                return mapper.map(oneString, twoString)
            }
        }

        class Fail(private val exception: Exception) : TestDataObject() {
            override fun map(mapper: DataMapper): DomainObject {
                return mapper.map(exception)
            }
        }
    }


    private interface DataMapper : Abstract.Mapper {
        fun map(textOneString: String, textTwoString: String): DomainObject
        fun map(exception: Exception): DomainObject

        class Base : DataMapper {
            override fun map(textOneString: String, textTwoString: String): DomainObject {
                return DomainObject.Success("$textOneString $textTwoString")
            }

            override fun map(exception: Exception): DomainObject {
                return DomainObject.Fail()
            }

        }
    }

    private sealed class DomainObject: Abstract.Object<UiObject, DomainToUiMapper>() {
        class Success(private val textCombined: String): DomainObject() {
            override fun map(mapper: DomainToUiMapper): UiObject {
                TODO("11.07.2021 not done yet")
            }
        }

        class Fail(): DomainObject() {
            override fun map(mapper: DomainToUiMapper): UiObject {
                TODO("Not done yet")
            }
        }
    }

    private interface DomainToUiMapper: Abstract.Mapper

    private sealed class UiObject: Abstract.Object<Unit, Abstract.Mapper.Empty>()
}

