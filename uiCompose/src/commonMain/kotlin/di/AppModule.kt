package di

import domain.di.dataModule
import domain.di.domainModule
import ui.di.uiModule

val appModule = dataModule + domainModule + uiModule