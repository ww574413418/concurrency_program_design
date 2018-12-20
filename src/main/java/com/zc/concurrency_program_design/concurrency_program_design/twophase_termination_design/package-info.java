/**
 * 当一个线程正常结束，或者因被打断而结束，或者因出现异常而结束时，我们需要考虑如何同时释放线程
 * 中资源，比如文件句柄、 socket套接字句柄、数据库连接等比较稀缺的资源。 Two Phase Termination设计模式
 * 我们使用“作业中”表示线程的执行状态，当希望结束这个线程时，发出线程结束请求终止要求，接下来线程不会立即结束，
 * 而是会执行相应的资源释放动作直到真正的结束，在终止处理状态时，线程虽释放资源然还在运行，但是进行的是终止处理工作，
 * 因此终止处理又称为线程结束的第二个阶段，而受理终止要求则被称为线程结束的第一个阶段。
 *
 * 在进行线程两阶段终结的时候需要考虑如下几个问题。
 * 01.第二阶段的终止保证安全性，比如涉及对共享资源的操作。
 * 02.要百分之百地确保线程结束，假设在第二个阶段出现了死循环、阻塞等异常导致无法结束。
 * 03.对资源的释放时间要控制在一个可控的范围之内。
 *
 * Two Phase Termination与其说是一个模式，还不如说是线程使用的一个技巧（best practice）。
 * 其主要针对的是当线程结束生命周期时，能有机会做一些资源释放的动作.
 *
 * 简单的一个模拟释放线程资源 {@link com.zc.concurrency_program_design.concurrency_program_design.twophase_termination_design.CounterIncrement}
 * 简单模拟的测试 {@link com.zc.concurrency_program_design.concurrency_program_design.twophase_termination_design.CounterTest}
 *
 * 简单创建一个socket客户端,并将客户端交个一个工作线程去执行工作{@link com.zc.concurrency_program_design.concurrency_program_design.twophase_termination_design.AppServer}
 * 执行具体工作的工作线程{@link com.zc.concurrency_program_design.concurrency_program_design.twophase_termination_design.ClientHandler}
 *
 */
package com.zc.concurrency_program_design.concurrency_program_design.twophase_termination_design;