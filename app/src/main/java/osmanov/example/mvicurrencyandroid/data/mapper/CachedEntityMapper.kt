package osmanov.example.mvicurrencyandroid.data.mapper

/**
 * Base interface for mappers.
 * Where [E] incoming class, [T] - outgoing class
 */
interface CachedEntityMapper<E, T> {

    fun mapToModel(type: E): T

    fun mapFromModel(type: T): E

}
