package app.shosetsu.android.common.ext

import android.content.Context
import android.content.Intent
import android.os.Bundle

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
 * 07 / 06 / 2020
 */

@Suppress("FunctionName")
inline fun Intent(packageContext: Context, cls: Class<*>, bundle: () -> Bundle): Intent =
	Intent(packageContext, cls).also { it.putExtras(bundle()) }