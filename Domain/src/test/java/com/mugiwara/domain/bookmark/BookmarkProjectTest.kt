package com.mugiwara.domain.bookmark

import com.mugiwara.domain.executor.PostExecutionThread
import com.mugiwara.domain.interactor.bookmark.BookmarkProject
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

class BookmarkProjectTest {

  private lateinit var bookmarkProject: BookmarkProject
  @Mock lateinit var projectsRepository: ProjectsRepository
  @Mock lateinit var postExecutionThread: PostExecutionThread

  @Before
  fun setup(){
    MockitoAnnotations.initMocks(this)
    bookmarkProject = BookmarkProject(projectsRepository, postExecutionThread)
  }

  @Test
  fun bookmarkProjectCompletes(){
        stubBookmarkProject(Completable.complete())
        val testObserverCompletable = bookmarkProject.buildUseCaseCompletable(
            BookmarkProject.Params.forProject(ProjectDataFactory.randomUuid())
        ).test()
        testObserverCompletable.assertComplete()

  }

  @Test (expected = IllegalArgumentException::class)
  fun bookmarkProjectThrowsException(){
    bookmarkProject.buildUseCaseCompletable().test()

  }


  private fun stubBookmarkProject(completable: Completable) {
    whenever(projectsRepository.bookmarkProject(any()))
        .thenReturn(completable)
  }
}
