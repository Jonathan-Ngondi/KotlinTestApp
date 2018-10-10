package com.mugiwara.domain.bookmark

import com.mugiwara.domain.executor.PostExecutionThread
import com.mugiwara.domain.interactor.bookmark.GetBookmarkedProjects
import com.mugiwara.domain.model.Project
import com.mugiwara.domain.repository.ProjectsRepository
import com.mugiwara.domain.test.ProjectDataFactory
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class GetBookmarkedProjectsTest {

  private lateinit var getBookmarkedProjects: GetBookmarkedProjects
  @Mock lateinit var projectsRepository: ProjectsRepository
  @Mock lateinit var postExecutionThread: PostExecutionThread

  @Before
  fun setup(){
    MockitoAnnotations.initMocks(this)
    getBookmarkedProjects = GetBookmarkedProjects(projectsRepository, postExecutionThread)
  }

  @Test
  fun getBookmarkedProjectsCompletes(){
    stubGetProjects(Observable.just(ProjectDataFactory.makeProjectList(2)))
    val testObserver = getBookmarkedProjects.buildUseCaseObservable().test()
    testObserver.assertComplete()

  }

  @Test
  fun getBookmarkedProjectsReturnsData(){
    val projects = ProjectDataFactory.makeProjectList(2)
    stubGetProjects(Observable.just(projects))
    val testObserver = getBookmarkedProjects.buildUseCaseObservable().test()
    testObserver.assertValue(projects)
  }

  private fun stubGetProjects(observable: Observable<List<Project>>){
    whenever(projectsRepository.getBookmarkedProjects())
        .thenReturn(observable)

  }
}