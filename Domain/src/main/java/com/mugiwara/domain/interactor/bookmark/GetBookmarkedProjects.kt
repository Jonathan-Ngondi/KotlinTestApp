package com.mugiwara.domain.interactor.bookmark

import com.mugiwara.domain.executor.PostExecutionThread
import com.mugiwara.domain.interactor.ObservableUseCase
import com.mugiwara.domain.model.Project
import com.mugiwara.domain.repository.ProjectsRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetBookmarkedProjects @Inject constructor(
  private val projectsRepository: ProjectsRepository,
  postExecutionThread: PostExecutionThread
): ObservableUseCase<List<Project>, Nothing>(postExecutionThread) {

  override fun buildUseCaseObservable(params: Nothing?): Observable<List<Project>> {
    return projectsRepository.getBookmarkedProjects()
  }

}