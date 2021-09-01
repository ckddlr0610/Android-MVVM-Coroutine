## Architecture

<img src="arts/mvvm.png" width="600px"/>

본 프로젝트는 UI 레이어와 Data 레이어로 구성된 MVVM 아키텍처로 설계했습니다. Data 레이어는 Repository를 통해 DataSource를 추상화하고 DataSource로는 로컬 저장소를 사용하는 Persistence와 네트워크 데이터를 사용하는 Remote로 구분됩니다.

기본적으로 Persistence의 데이터를 로드하고, 만약 해당하는 데이터가 없으면 Remote DataSource에서 데이터를 가져옵니다.

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

