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

package com.hds.hdswallet.screens.change_address

import com.hds.hdswallet.base_screen.BaseRepository
import com.hds.hdswallet.core.entities.OnAddressesData
import com.hds.hdswallet.core.entities.WalletAddress
import com.hds.hdswallet.core.helpers.Tag
import com.hds.hdswallet.core.helpers.TagHelper
import com.hds.hdswallet.core.helpers.TrashManager
import com.hds.hdswallet.core.listeners.WalletListener
import io.reactivex.subjects.Subject

class ChangeAddressRepository: BaseRepository(), ChangeAddressContract.Repository {
    override fun getAddresses(): Subject<OnAddressesData> {
        return getResult(WalletListener.subOnAddresses, "getAddresses") {
            wallet?.getAddresses(true)
            wallet?.getAddresses(false)
        }
    }

    override fun getAddressTags(address: String): List<Tag> {
        return TagHelper.getTagsForAddress(address)
    }

    override fun getTrashSubject(): Subject<TrashManager.Action> {
        return TrashManager.subOnTrashChanged
    }

    override fun getAllAddressesInTrash(): List<WalletAddress> {
        return TrashManager.getAllData().addresses
    }
}