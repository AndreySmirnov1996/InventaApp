package ru.rubberteam.inventa.components

import dagger.Component
import ru.rubberteam.inventa.activities.MainActivity
import ru.rubberteam.inventa.activities.login.LoginActivity
import ru.rubberteam.inventa.activities.login.PinCodeActivity
import ru.rubberteam.inventa.activities.login.RepeatPinCodeActivity
import ru.rubberteam.inventa.modules.RetrofitClientModule
import ru.rubberteam.inventa.modules.SecurityModule
import ru.rubberteam.inventa.services.RetrofitClientService

@Component(modules = [SecurityModule::class, RetrofitClientModule::class])
interface AppComponent {

	fun injectLoginActivity(loginActivity: LoginActivity)

	fun injectMainActivity(mainActivity: MainActivity)

	fun injectRepeatPinCodeActivity(repeatPinCodeActivity: RepeatPinCodeActivity)

	fun injectPinCodeActivity(pinCodeActivity: PinCodeActivity)
}