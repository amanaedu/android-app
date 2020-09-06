package com.github.doomsdayrs.apps.shosetsu.viewmodel.abstracted

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.github.doomsdayrs.apps.shosetsu.common.dto.HResult
import com.github.doomsdayrs.apps.shosetsu.domain.usecases.LoadAppUpdateUseCase
import com.github.doomsdayrs.apps.shosetsu.viewmodel.base.IsOnlineCheckViewModel

/*
 * This file is part of shosetsu.
 *
 * shosetsu is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * shosetsu is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with shosetsu.  If not, see <https://www.gnu.org/licenses/>.
 */

/**
 * shosetsu
 * 20 / 06 / 2020
 */
abstract class IMainViewModel : ViewModel(), IsOnlineCheckViewModel {
	abstract fun share(string: String, int: String)

	abstract fun startDownloadWorker()

	@Deprecated("Now auto started")
	abstract fun startUpdateWorker()

	abstract fun startUpdateCheck(): LiveData<HResult<LoadAppUpdateUseCase.DebugAppUpdate>>
}