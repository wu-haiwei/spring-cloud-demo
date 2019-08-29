1. 隔离请求的方式有两种类型
    线程隔离: thread：Hystrix 的默认隔离策略。系统会创建一个依赖线程池，为每个依赖请求分配一个独立的线程，而每个依赖所拥有的线程数量是有上限的。当对该依赖的调用请求数量达到上限后再有请求，则该请求阻塞。所以对某依赖的并发量取决于为该依赖所分配的线程数量。
    信号量隔离：对依赖的调用所使用的线程仍为请求线程，即不会为依赖请求再新创建新的线程。但系统会为每种依赖分配一定数量的信号量，而每个依赖请求分配一个信号号。当对该依赖的调用请求数量达到上限后再有请求，则该请求阻塞。所以对某依赖的并发量取决于为该依赖所分配的信号号数量。
        
2. 修改策略:
    配置文件
     hystrix.command.default.execution.isolation.strategy=thread
     hystrix.command.default.execution.isolation.strategy=semaphore

   代码
     HystrixCommandProperties.Setter().withExecutionIsolationStrategy(ExecutionIsolationStrategy.THREAD)
     HystrixCommandProperties.Setter().withExecutionIsolationStrategy(ExecutionIsolationStrategy.SEMAPHORE)
    
2. 默认值
    在 HystrixCommandProperties 类的构造器中设置有这些高级属性的默认值。
    
4. 线程执行超时时限
    在默认的线程执行隔离策略中，关于线程的执行时间，可以为其设置超时时限。当然，首先通过下面的属性开启该超时时限，该属性默认是开启的，即默认值为 true。若要关闭，则可以配置文件中设置该属性的值为 false。
     hystrix.command.default.execution.timeout.enabled
    在开启了执行线程超时时限后，可以通过以下属性设置时限长度。其默认值为 1000 毫秒。
     hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds
    
5. 超时中断
    当线程执行超时时是否中断线程的执行。默认为 true，即超时即中断。通过以下属性进行设置。
     hystrix.command.default.execution.isolation.thread.interruptOnTimeout
    
6. 取消中断
    在线程执行过程中，若请求取消了，当前执行线程是否结束呢？由该值设置。默认为 false, 即取消后不中断。通过以下属性进行设置。
     hystrix.command.default.execution.isolation.thread.interruptOnCancel
    