/**
 * 不可变对象设计

  无论是synchronized关键字还是显示锁lock,都会牺牲系统的性能,不可改变对象的设计理念越来越重要.

  java核心类库中提供了大量的不可变对象的范例.其中`String`的每一个方法都没有被同步修辞,但是在多线程访问的时候是线程安全的,java8中通过`Stream``修辞的ArrayList在函数式方法并行访问的情况下也是线程安全的.

  所谓不可改变对象是没有机会去修改它的对象,每一次的修改都会导致产生一个新对象
  不可变对象一定是线程安全的

  可变对象不一定是线程不安全的 ->Stringbuffer 是线程安全的 但是是可变的

  线程不安全的累加器{@link com.zc.concurrency_program_design.concurrency_program_design.invarible_object.IntegerAcumulator}
  使用了不可变对象设计的累加器,是全局安全的{@link com.zc.concurrency_program_design.concurrency_program_design.invarible_object.IntegarAcumulator2}
 */
package com.zc.concurrency_program_design.concurrency_program_design.invarible_object;