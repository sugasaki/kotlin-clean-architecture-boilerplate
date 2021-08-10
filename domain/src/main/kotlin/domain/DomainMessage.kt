package domain

sealed class DomainMessage

/* exposed errors */

object UserNotFound : DomainMessage()
