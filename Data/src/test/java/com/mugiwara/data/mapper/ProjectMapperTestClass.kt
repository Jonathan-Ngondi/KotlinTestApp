package com.mugiwara.data.mapper

import com.mugiwara.data.model.ProjectEntity
import com.mugiwara.data.test.factory.ProjectFactory
import com.mugiwara.domain.model.Project
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.assertEquals

@RunWith(JUnit4::class)
class ProjectMapperTestClass {
  private val mapper = ProjectMapper()

  @Test
  fun mapFromEntitiyMapsData(){
    val entity = ProjectFactory.makeProjectEntity()
    val model = mapper.mapFromEntity(entity)
    assertEqualData(entity, model)
  }

  @Test
  fun mapToEntityMapsData(){
    val model = ProjectFactory.makeProject()
    val entity = mapper.mapToEntity(model)
    assertEqualData(entity, model)
  }
   private fun assertEqualData(entity: ProjectEntity, model: Project){
     assertEquals(entity.id, model.id)
     assertEquals(entity.fullName, model.fullName)
     assertEquals(entity.name, model.name)
     assertEquals(entity.starCount, model.starCount)
     assertEquals(entity.dateCreated, model.dateCreated)
     assertEquals(entity.ownerName, model.ownerName)
     assertEquals(entity.isBookmarked, model.isBookmarked)

   }
}