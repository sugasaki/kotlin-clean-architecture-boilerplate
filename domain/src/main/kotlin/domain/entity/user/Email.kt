package domain.entity.user

import domain.entity.IValueClass
import domain.exceptions.EmailInvalidException

data class Email(override val value: String) : IValueClass<String> {
    init {
        if (!value.contains('@')) throw EmailInvalidException()
    }
}
