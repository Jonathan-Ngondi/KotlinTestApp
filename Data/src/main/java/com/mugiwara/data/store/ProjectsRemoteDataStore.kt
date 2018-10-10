package com.mugiwara.data.store

import com.mugiwara.data.model.ProjectEntity
import com.mugiwara.data.repository.ProjectRemote
import com.mugiwara.data.repository.ProjectsDataStore
import io.reactivex.Completable
import io.reactivex.Observable
import java.lang.UnsupportedOperationException
import javax.inject.Inject

class ProjectsRemoteDataStore @Inject constructor(private val projectsRemote: ProjectRemote): ProjectsDataStore {
  override fun getProjects(): Observable<List<ProjectEntity>> {
    return projectsRemote.getProjects()
  }

  override fun clearProjects(): Completable {
    throw UnsupportedOperationException("Clearing projects isn't supported here...")
  }

  override fun saveProjects(projects: List<ProjectEntity>): Completable {
    throw UnsupportedOperationException("Saving projects isn't supported here...")
  }

  override fun getBookmarkedProjects(): Observable<List<ProjectEntity>> {
    throw UnsupportedOperationException("Getting bookmarked projects isn't supported here...")
  }

  override fun setProjectAsBookmarked(projectId: String): Completable {
    throw UnsupportedOperationException("Setting bookmarked projects isn't supported here...")
  }

  override fun setProjectAsNotBookmarked(projectId: String): Completable {
    throw UnsupportedOperationException("Unbookmarking projects isn't supported here...")
  }

}