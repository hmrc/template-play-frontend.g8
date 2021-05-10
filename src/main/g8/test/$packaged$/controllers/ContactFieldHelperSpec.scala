/*
 * Copyright 2021 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package $package$.controllers

import $package$.support.UnitSpec
import $package$.support.FormMatchers

class ContactFieldHelperSpec extends UnitSpec with FormMatchers {

  "ContactFieldHelper" should {

    "normaliseNumber" in {
      ContactFieldHelper.normaliseNumber("01234567898") shouldBe "01234567898"
      ContactFieldHelper.normaliseNumber("+441234567898") shouldBe "01234567898"
      ContactFieldHelper.normaliseNumber("441234567898") shouldBe "01234567898"
      ContactFieldHelper.normaliseNumber("00441234567898") shouldBe "01234567898"
    }

    "removeNonAllowedCharacters" in {
      ContactFieldHelper.removeNonAllowedCharacters("123456 123") shouldBe "123456123"
      ContactFieldHelper.removeNonAllowedCharacters("123-456-123") shouldBe "123456123"
      ContactFieldHelper.removeNonAllowedCharacters("(123456123") shouldBe "123456123"
      ContactFieldHelper.removeNonAllowedCharacters("123)456123") shouldBe "123456123"
      ContactFieldHelper.removeNonAllowedCharacters("(123) 456-123") shouldBe "123456123"
    }

    "formatNumber" in {
      ContactFieldHelper.replayNumber("01234567891") shouldBe "01234 567 891"
    }
  }
}
