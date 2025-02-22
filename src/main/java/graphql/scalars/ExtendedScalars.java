package graphql.scalars;

import graphql.PublicApi;
import graphql.scalars.java.JavaPrimitives;
import graphql.schema.GraphQLScalarType;

/**
 * This is the API entry point for all the extended scalars
 */
@PublicApi
public class ExtendedScalars {

    /**
     * This represents the "Long" type which is a representation of java.lang.Long
     */
    public static final GraphQLScalarType GraphQLLong = JavaPrimitives.GraphQLLong;

    /**
     * This represents the "Short" type which is a representation of java.lang.Short
     */
    public static final GraphQLScalarType GraphQLShort = JavaPrimitives.GraphQLShort;

    /**
     * This represents the "Byte" type which is a representation of java.lang.Byte
     */
    public static final GraphQLScalarType GraphQLByte = JavaPrimitives.GraphQLByte;

    /**
     * This represents the "BigDecimal" type which is a representation of java.math.BigDecimal
     */
    public static final GraphQLScalarType GraphQLBigDecimal = JavaPrimitives.GraphQLBigDecimal;

    /**
     * This represents the "BigInteger" type which is a representation of java.math.BigInteger
     */
    public static final GraphQLScalarType GraphQLBigInteger = JavaPrimitives.GraphQLBigInteger;

    /**
     * This represents the "Char" type which is a representation of java.lang.Character
     */
    public static final GraphQLScalarType GraphQLChar = JavaPrimitives.GraphQLChar;

}
