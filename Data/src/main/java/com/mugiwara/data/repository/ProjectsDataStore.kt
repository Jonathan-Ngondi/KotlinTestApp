package com.mugiwara.data.repository

import com.mugiwara.data.model.ProjectEntity
import io.reactivex.Completable
import io.reactivex.Observable

interface ProjectsDataStore {

  fun getProjects(): Observable<List<ProjectEntity>>

  fun clearProjects(): Completable

  fun saveProjects(projects: List<ProjectEntity>): Completable

  fun getBookmarkedProjects(): Observable<List<ProjectEntity>>

  fun setProjectAsBookmarked(projectId: String): Completable

  fun setProjectAsNotBookmarked(projectId: String): Completable

}