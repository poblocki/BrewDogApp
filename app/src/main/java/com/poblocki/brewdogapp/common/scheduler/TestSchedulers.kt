package com.poblocki.brewdogapp.common.scheduler

import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

class TestSchedulers : AppSchedulers {
	override val dbIO: Scheduler
		get() = Schedulers.trampoline()
	override val diskIO: Scheduler
		get() = Schedulers.trampoline()
	override val networkIO: Scheduler
		get() = Schedulers.trampoline()
	override val mainThread: Scheduler
		get() = Schedulers.trampoline()
}