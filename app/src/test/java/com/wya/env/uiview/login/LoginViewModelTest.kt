package com.wya.env.uiview.login

import android.app.Application
import android.view.View
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

/**
 * @author : xdl
 * @time : 2019/08/26
 * @describe :
 */
class LoginViewModelTest {
    private val repository = mock(LoginRepository::class.java)
    private val application = mock(Application::class.java)
    private val loginViewModel=LoginViewModel(application,repository)


    @Test
    fun getAdminInput() {
    }

    @Test
    fun getAdminPwd() {
    }

    @Test
    fun getLoginInfo() {
    }

    @Test
    fun setLoginInfo() {
    }

    @Test
    fun onClickLogin() {
//        loginViewModel.adminInput.postValue("admin")
//        loginViewModel.adminPwd.postValue("admin")
        loginViewModel.onClickLogin(mock(View::class.java))

        verify(repository).login("admin","admin")
    }


    @Test
    fun initTitle() {

    }

    @Test
    fun saveLoginInfo() {

    }

    @Test
    fun onCleared() {

    }
}