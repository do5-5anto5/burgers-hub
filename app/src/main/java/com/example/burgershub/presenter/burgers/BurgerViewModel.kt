package com.example.burgershub.presenter.burgers

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.burgershub.data.model.ErrorResponse
import com.example.burgershub.domain.usecase.GetBurgerByIdUseCase
import com.example.burgershub.domain.usecase.GetBurgerByNameUseCase
import com.example.burgershub.domain.usecase.GetBurgersUseCase
import com.example.burgershub.util.StateView
import com.example.burgershub.util.getErrorResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class BurgerViewModel @Inject constructor(
    private val getBurgersUseCase: GetBurgersUseCase,
    private val getBurgerByNameUseCase: GetBurgerByNameUseCase,
    private val getBurgerByIdUseCase: GetBurgerByIdUseCase
): ViewModel() {

    fun getBurgers() = liveData(Dispatchers.IO) {
        try {
            emit(StateView.Loading())

            val burgers = getBurgersUseCase()

            emit(StateView.Success(data = burgers))
        } catch (e: HttpException) {

            val error = e.getErrorResponse<ErrorResponse>()
            emit(StateView.Error(message = error?.message))

        } catch (e: Exception) {

            e.printStackTrace()
            emit(StateView.Error(message = e.message))

        }
    }

    fun getBurgerByName(id: Int) = liveData(Dispatchers.IO) {
        try {
            emit(StateView.Loading())

            val burger = getBurgerByIdUseCase(id)

            emit(StateView.Success(data = burger))
        } catch (e: HttpException) {

            val error = e.getErrorResponse<ErrorResponse>()
            emit(StateView.Error(message = error?.message))

        } catch (e: Exception) {

            e.printStackTrace()
            emit(StateView.Error(message = e.message))

        }
    }

    fun getBurgerById(name: String) = liveData(Dispatchers.IO) {
        try {
            emit(StateView.Loading())

            val burgers = getBurgerByNameUseCase(name)

            emit(StateView.Success(data = burgers))
        } catch (e: HttpException) {

            val error = e.getErrorResponse<ErrorResponse>()
            emit(StateView.Error(message = error?.message))

        } catch (e: Exception) {

            e.printStackTrace()
            emit(StateView.Error(message = e.message))

        }
    }
}