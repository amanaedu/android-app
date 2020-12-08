package app.shosetsu.android.datasource.memory.model.guava

import app.shosetsu.android.common.ext.get
import app.shosetsu.android.common.ext.set
import app.shosetsu.android.datasource.memory.base.IMemChaptersDataSource
import app.shosetsu.common.com.consts.MEMORY_EXPIRE_CHAPTER_TIME
import app.shosetsu.common.com.consts.MEMORY_MAX_CHAPTERS
import app.shosetsu.common.com.dto.HResult
import app.shosetsu.common.com.dto.emptyResult
import app.shosetsu.common.com.dto.successResult
import com.google.common.cache.Cache
import com.google.common.cache.CacheBuilder
import java.util.concurrent.TimeUnit.MINUTES

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
 * 04 / 05 / 2020
 */
class GuavaMemChaptersDataSource : IMemChaptersDataSource {
	/** Map of Chapter ID to Chapter Passage */
	private val chapters: Cache<Int, String> = CacheBuilder.newBuilder()
			.maximumSize(MEMORY_MAX_CHAPTERS)
			.expireAfterWrite(MEMORY_EXPIRE_CHAPTER_TIME, MINUTES)
			.build()

	override suspend fun saveChapterInCache(chapterID: Int, passage: String): HResult<*> =
			successResult(chapters.set(chapterID, passage))

	override suspend fun loadChapterFromCache(chapterID: Int): HResult<String> =
			chapters[chapterID]?.let { successResult(it) } ?: emptyResult()
}