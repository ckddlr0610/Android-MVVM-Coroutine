## Code Style

Code Style을 정의함으로써 프로젝트 전반적으로 Code Style을 통일시키고, 코드 작성에서의 실수를 방지합니다.

전체적으로 안드로이드 공식 문서의 [Kotlin Style Guide](https://developer.android.com/kotlin/style-guide#whitespace)를 적용하고, google의 [java style guide](https://google.github.io/styleguide/javaguide.html#s4.3-one-statement-per-line)를 참조했습니다.



파일 인코딩 (File Encoding)

모든 소스 파일은 UTF-8로 인코딩됩니다.



들여쓰기 (Indent)

들여쓰기는 4칸으로 설정합니다.



구조 (Structure)

import에서 모든 유형의 와일드 카드 형태는 허용하지 않습니다.

import는 줄바꿈이 없습니다.

Kotlin 파일 내에 Companion object가 있다면 Companion Object를 최상단에 위치시킵니다.

파일의 네임은 최상위 클래스가 하나인 경우 클래스 네임.kt로 하고, 최상위 수준이 여러개인 경우는 해당 파일을 잘 설명할 수 있는 이름을 선택합니다.



줄바꿈 (Line Wrapping)

줄바꿈의 목표는 코드를 가장 명확히 보여주는 것입니다.

Column limit은 100으로 합니다. 100자를 넘어가는 라인의 경우 줄바꿈 합니다.

If, for문 앞에서 줄바꿈을 합니다.

람다 화살표는 인수 목록과 연결된 상태로 유지합니다.



함수 (Function)

함수는 매개 변수 목록이 한줄에 들어가지 않는 경우,

매개 변수 목록을 한 줄에 하나씩 표현합니다.

하나의 expression만 가지는 함수의 경우 (값을 하나만 리턴하는) expression 형식으로 함수를 작성합니다.