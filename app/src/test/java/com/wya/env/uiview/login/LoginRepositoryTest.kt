package com.wya.env.uiview.login

import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers

/**
 * @author : xdl
 * @time : 2019/08/23
 * @describe :
 */
class LoginRepositoryTest {

    private val name= ArgumentMatchers.anyString()
    private val pwd=ArgumentMatchers.anyString()
//    private val clazz=ArgumentMatchers.any(Any::class.java)
    private val loginRepo = LoginRepository(LoginActivity::class.java)


    @Before
    @Throws(Exception::class)
    fun setUp() {
    }

    @Test
    fun login() {
        loginRepo.login(name,pwd)
    }
}