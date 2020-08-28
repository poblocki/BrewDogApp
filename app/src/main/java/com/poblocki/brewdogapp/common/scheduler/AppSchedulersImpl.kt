package com.poblocki.brewdogapp.common.scheduler

import io.reactivex.Scheduler
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Singleton
class AppSchedulersImpl @Inject constructor(
	@Named("dbScheduler") override val dbIO: Scheduler,
	@Named("diskIOScheduler") override val diskIO: Scheduler,
	@Named("networkScheduler") override val networkIO: Scheduler,
	@Named("mainThreadScheduler") override val mainThread: Scheduler
) : AppSchedulers