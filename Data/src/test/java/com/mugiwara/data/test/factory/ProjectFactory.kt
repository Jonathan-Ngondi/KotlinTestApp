package com.mugiwara.data.test.factory

import com.mugiwara.data.model.ProjectEntity
import com.mugiwara.domain.model.Project

object ProjectFactory {

  fun makeProjectEntity(): ProjectEntity {
    return ProjectEntity(DataFactory.randomString(),
        DataFactory.randomString(), DataFactory.randomString(),
        DataFactory.randomString(), DataFactory.randomString(),
        DataFactory.randomString(), DataFactory.randomString(),
        DataFactory.randomBoolean())
  }

  fun makeProject(): Project {
    return Project(DataFactory.randomString(),
        DataFactory.randomString(), DataFactory.randomString(),
        DataFactory.randomString(), DataFactory.randomString(),
        DataFactory.randomString(), DataFactory.randomString(),
        DataFactory.randomBoolean())
  }
}