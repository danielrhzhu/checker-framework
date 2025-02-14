package org.checkerframework.checker.index.qual;

import org.checkerframework.framework.qual.DefaultQualifierInHierarchy;
import org.checkerframework.framework.qual.InvisibleQualifier;
import org.checkerframework.framework.qual.SubtypeOf;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The top qualifier for the LessThan type hierarchy. It indicates that no other expression is known
 * to be larger than the annotated one.
 *
 * @checker_framework.manual #index-inequalities Index Chceker Inequalities
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
@SubtypeOf({})
@DefaultQualifierInHierarchy
@InvisibleQualifier
public @interface LessThanUnknown {}
