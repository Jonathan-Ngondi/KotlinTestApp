package com.mugiwara.domain.bookmark

import com.mugiwara.domain.executor.PostExecutionThread
import com.mugiwara.domain.interactor.bookmark.UnbookmarkProject
import com.mugiwara.domain.repository.ProjectsRepository
import com.mugiwara.domain.test.ProjectDataFactory
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Completable
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import java.lang.IllegalArgumentException

class UnbookmarkProjectTest {

  private lateinit var unbookmarkProject: UnbookmarkProject
  @Mock lateinit var  projectsRepository: ProjectsRepository
  @Mock lateinit var postExecutionThread: PostExecutionThread


  @Before
  fun setup(){
    MockitoAnnotations.initMocks(this)
    unbookmarkProject = UnbookmarkProject(projectsRepository, postExecutionThread)

  }

  @Test
  fun unbookmarkProjectCompletes(){
    stubUnbookmarkProject(Completable.complete())
    var testObserver = unbookmarkProject.buildUseCaseCompletable(
        UnbookmarkProject.Params.forProject(ProjectDataFactory.randomUuid())).test()
    testObserver.assertComplete()

  }

  @Test(expected = IllegalArgumentException::class)
  fun unbookmarkProjectThrowsException(){
    unbookmarkProject.buildUseCaseCompletable().test()
  }



  private fun stubUnbookmarkProject(completable: Completable){
    whenever(projectsRepository.unbookmarkProject(any()))
        .thenReturn(completable)
  }





}