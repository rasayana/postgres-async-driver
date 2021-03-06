package com.github.pgasync;

import com.github.pgasync.impl.Oid;

/**
 * Converters extend the driver to handle complex data types,
 * for example json or hstore that have no "standard" Java
 * representation.
 *
 * @author Antti Laisi.
 */
public interface Converter<T> {

    /**
     * @return Class to convert
     */
    Class<T> type();

    /**
     * @param o Object to convert, never null
     * @return data in backend format
     */
    byte[] from(T o);

    /**
     * @param oid Value oid
     * @param value Value in backend format, never null
     * @return Converted object, never null
     */
    T to(Oid oid, byte[] value);

}
