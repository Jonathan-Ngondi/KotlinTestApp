package com.mugiwara.data.repository

import com.mugiwara.data.model.ProjectEntity
import io.reactivex.Observable

interface ProjectRemote {

  fun getProjects(): Observable<List<ProjectEntity>>



}