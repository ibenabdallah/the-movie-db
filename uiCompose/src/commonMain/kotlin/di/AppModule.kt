package di

import domain.di.dataModule
import domain.di.domainModule

val appModule = dataModule + domainModule + uiModule