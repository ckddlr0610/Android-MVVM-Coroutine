## Architecture

<img src="arts/mvvm.png" width="600px"/>

이 프로젝트는 UI 레이어와 Data 레이어로 구분된 MVVM 아키텍처로 설계됐습니다. Data 레이어는 Repository를 통해 Data Source를 추상화하며, Data Source는 로컬 저장소로부터 데이터를 불러오는 Persistence와 네트워크로부터 불러오는 Remote로 구분됩니다. 

데이터를 불러올 때는 Persistence에 데이터가 있는지 확인 후, 데이터가 없다면 Remote로부터 데이터를 불러옵니다.

UI에 표현되는 데이터는 ViewModel에서 저장하며, AAC Lifecycle의 LiveData를 사용해 View와 데이터를 동기화시킵니다.

## Credit

- Android Jetpack

  - UI
    - Fragment
    - ConstraintLayout
    - ...

  - Architecture
    - Data Binding
    - Lifecycles
    - LiveData
    - Navigation
    - Hilt
    - Room

- Kotlin

  - Coroutines
  - Coroutines Flow

- Retrofit2

