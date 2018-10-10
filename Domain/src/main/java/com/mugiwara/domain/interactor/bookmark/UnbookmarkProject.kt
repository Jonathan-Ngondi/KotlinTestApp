package com.mugiwara.domain.interactor.bookmark

import com.mugiwara.domain.executor.PostExecutionThread
import com.mugiwara.domain.interactor.CompletableUseCase
import com.mugiwara.domain.interactor.bookmark.UnbookmarkProject.Params
import com.mugiwara.domain.repository.ProjectsRepository
import io.reactivex.Completable
import java.lang.IllegalArgumentException
import javax.inject.Inject

class UnbookmarkProject @Inject constructor(
  private val projectsRepository: ProjectsRepository,
  postExecutionThread: PostExecutionThread
): CompletableUseCase<Params>(postExecutionThread) {

  override fun buildUseCaseCompletable(params: Params?): Completable {
    if(params == null) throw IllegalArgumentException("Params can't be null!")
    return projectsRepository.unbookmarkProject(params.projectId)
  }

  data class Params constructor(val projectId: String){
    companion object {
      fun forProject(projectID: String): Params {
        return Params(projectID)
      }
    }
  }

}