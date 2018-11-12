package com.mugiwara.data.store

import com.nhaarman.mockitokotlin2.mock
import org.junit.Before
import org.junit.Test
import org.mockito.MockitoAnnotations
import kotlin.test.assertEquals

class ProjectsDataStoreFactoryTest {


  private val cacheStore = mock<ProjectsCacheDataStore>()
  private val remoteStore = mock<ProjectsRemoteDataStore>()
  private val factory = ProjectsDataStoreFactory(cacheStore, remoteStore)


  @Before
  fun setup(){
    MockitoAnnotations.initMocks(this)

  }

  @Test
  fun getDataStoreReturnsRemoteStoreWhenCacheExpired(){
    assertEquals(remoteStore, factory.getDataStore(true, true))
  }

  @Test
  fun getDataStoreReturnsRemoteStoreWhenNotCached(){
    assertEquals(remoteStore, factory.getDataStore(false,false))
  }

  @Test
  fun getDataStoreReturnsCachedWhenCacheNotExpired(){
    assertEquals(cacheStore, factory.getDataStore(true, false))
  }

  @Test
  fun getCacheDataStoreReturnsCacheStore(){
    assertEquals(cacheStore, factory.getCacheDataStore())
  }




}