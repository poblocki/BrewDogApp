package com.poblocki.brewdogapp.common.scheduler

import io.reactivex.Scheduler

interface AppSchedulers {
	val dbIO: Scheduler
	val diskIO: Scheduler
	val networkIO: Scheduler
	val mainThread: Scheduler
}