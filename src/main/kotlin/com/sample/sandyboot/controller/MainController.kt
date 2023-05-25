package com.sample.sandyboot.controller

import com.sample.sandyboot.dto.FirebaseDTO
import com.sample.sandyboot.service.CrudService
import com.sample.sandyboot.service.FirebaseService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
class MainController(val firebaseService: FirebaseService,
                     val crudService: CrudService) { //코틀린 생성자 injection or Kotlin Autowired

    @GetMapping("/main")
//    Read
    fun home(): ResponseEntity<List<FirebaseDTO>> {
     val result = firebaseService.getDocuments()
        return ResponseEntity.ok().body(result)
    }

    @PostMapping("/add")
//    Insert
    fun add(@RequestBody firebaseDTO: FirebaseDTO): ResponseEntity<Boolean>? {
        val result = crudService.createDocs(firebaseDTO)
        return ResponseEntity.ok().body(result)

    }
// ResponseEntity : 사용자의 HttpRequest에 대한 응답 데이터를 포함하는 클래스(HttpEntity 상속받음)
//    Update

    @PutMapping("/update")
    fun update(@RequestBody firebaseDTO: FirebaseDTO): ResponseEntity<Boolean>? {
        val result = crudService.updateDocs(firebaseDTO)

       return  ResponseEntity.ok().body(result)
    }

//    Delete

    @DeleteMapping("/delete/{docId}")
    fun delete(@PathVariable docId: String): ResponseEntity<Boolean>? {
        val result = crudService.deleteDocs(docId)

        return ResponseEntity.ok().body(result)
    }

//    fun search(@RequestBody firebaseDTO: FirebaseDTO): ResponseEntity<Boolean>? {
//
//    }
}


