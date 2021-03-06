/*
 * // Copyright 2018 Hds Development
 * //
 * // Licensed under the Apache License, Version 2.0 (the "License");
 * // you may not use this file except in compliance with the License.
 * // You may obtain a copy of the License at
 * //
 * //    http://www.apache.org/licenses/LICENSE-2.0
 * //
 * // Unless required by applicable law or agreed to in writing, software
 * // distributed under the License is distributed on an "AS IS" BASIS,
 * // WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * // See the License for the specific language governing permissions and
 * // limitations under the License.
 */

package com.hds.hdswallet.screens.currency

import com.hds.hdswallet.base_screen.MvpPresenter
import com.hds.hdswallet.base_screen.MvpRepository
import com.hds.hdswallet.base_screen.MvpView
import com.hds.hdswallet.core.entities.Currency
import com.hds.hdswallet.core.entities.ExchangeRate

interface CurrencyContract {

    interface View: MvpView {
        fun init(currencies: List<ExchangeRate>, currency: Currency)
        fun changeCurrency(currency: Currency)
    }

    interface Presenter: MvpPresenter<View> {
        fun onSelectCurrency(currency: Currency)
    }

    interface Repository: MvpRepository {
        fun getCurrencies(): List<ExchangeRate>
        fun getCurrentCurrency(): Currency
        fun setCurrency(currency: Currency)
    }
}