package app.shosetsu.android.domain.repository.base
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
import app.shosetsu.android.domain.model.local.UpdateCompleteEntity
import app.shosetsu.android.domain.model.local.UpdateEntity
import app.shosetsu.common.com.dto.HResult
import kotlinx.coroutines.flow.Flow


/**
 * shosetsu
 * 25 / 04 / 2020
 *
 * @author github.com/doomsdayrs
 */
interface IUpdatesRepository {
	/** Adds updates */
	suspend fun addUpdates(list: List<UpdateEntity>): HResult<Array<Long>>

	/** Get all LiveData of the updates */
	suspend fun getUpdates(): Flow<HResult<List<UpdateEntity>>>

	/** Get all LiveData of the updates with completion */
	suspend fun getCompleteUpdates(): Flow<HResult<List<UpdateCompleteEntity>>>
}