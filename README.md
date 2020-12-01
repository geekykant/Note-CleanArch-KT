# NoteMe-KT ✏️
A clean-modern note taking application build completely on Kotlin ❤️ It emphasises the use of clean architecture following SOLID principles. The modern frameworks makes it flexible and easily testable for future developments. 🚀

## Package Structure
```
com.paavam.noteme    # app package (root)
.
|-- framework
|   |-- NoteViewModel.kt
|   |-- RoomNoteDataSource.kt
|   |-- UseCases.kt
|   |-- db
|   |   |-- DatabaseService.kt
|   |   |-- ListViewModel.kt
|   |   |-- NoteDao.kt
|   |   `-- NoteEntity.kt
|   `-- di
|       |-- ApplicationModule.kt
|       |-- RepositoryModule.kt
|       |-- UseCasesModule.kt
|       `-- ViewModelComponent.kt
`-- presentation
    |-- ListAction.kt
    |-- ListFragment.kt
    |-- MainActivity.kt
    |-- NoteFragment.kt
    `-- NotesListAdapter.kt
    
com.paavam.core    # core package
.
|-- data
|   `-- Node.kt
|-- repository
|   |-- NoteDataSource.kt
|   `-- NoteRepository.kt
`-- usecase
    |-- AddNote.kt
    |-- GetAllNotes.kt
    |-- GetNote.kt
    |-- GetWordCount.kt
    `-- RemoveNote.kt
```

## Clean Architecture
Clean Architecture uses the concept of separating codes in different modules or sections for easier maintenence and modifications. Read the [detailed guide here](https://medium.com/android-dev-hacks/detailed-guide-on-android-clean-architecture-9eab262a9011).

<img src="https://miro.medium.com/max/700/1*wOmAHDN_zKZJns9YDjtrMw.jpeg">

## Want to Contribute 👋
You are welcome to contribute to the project following with new features or enhanced performance. It is assumed that you will be following the same coding patterns and clean architecture.

## Contributors 
- [Sreekant Shenoy](https://github.com/geekykant)

## License

```
Copyright 2020 Sreekant Shenoy

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
