/*
 * Copyright The OpenTelemetry Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package io.opentelemetry.contrib.sampler.consistent;

/**
 * A function for generating r-values.
 *
 * <p>The distribution of r-values generated by this function must satisfy the table below.
 *
 * <table>
 * <caption>Required distribution of r-values</caption>
 * <thead>
 *   <tr><th>r-value</th><th>Probability of r-value</th></tr>
 * </thead>
 * <tbody>
 *   <tr><td>0</td><td>1/2</td></tr>
 *   <tr><td>1</td><td>1/4</td></tr>
 *   <tr><td>2</td><td>1/8</td></tr>
 *   <tr><td>3</td><td>1/16</td></tr>
 *   <tr><td>…</td><td>…</td></tr>
 *   <tr><td>0 &lt;= r &lt;= 61</td><td>2**-(r+1)</td></tr>
 *   <tr><td>…</td><td>…</td></tr>
 *   <tr><td>59</td><td>2**-60</td></tr>
 *   <tr><td>60</td><td>2**-61</td></tr>
 *   <tr><td>61</td><td>2**-62</td></tr>
 *   <tr><td>>=62</td><td>2**-62</td></tr>
 * </tbody>
 * </table>
 *
 * For more info see <a
 * href="https://opentelemetry.io/docs/reference/specification/trace/tracestate-probability-sampling/#methods-for-generating-r-values">Methods
 * for generating R-values</a>.
 */
@FunctionalInterface
public interface RValueGenerator {

  int generate(String traceId);
}