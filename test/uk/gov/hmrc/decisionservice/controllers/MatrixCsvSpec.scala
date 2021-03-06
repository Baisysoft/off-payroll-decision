/*
 * Copyright 2017 HM Revenue & Customs
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

package uk.gov.hmrc.decisionservice.controllers

import uk.gov.hmrc.play.test.{UnitSpec, WithFakeApplication}

class MatrixCsvSpec extends UnitSpec with WithFakeApplication with DecisionControllerCsvSpec {
  val clusterName = "matrix"

  val TEST_CASE_UNKNOWN = "/test-scenarios/single/scenario-final-unknown.csv"
  val TEST_CASE_OUTOFIR35 = "/test-scenarios/single/scenario-earlyexit-outofir35.csv"
  val TEST_CASE_INSIDEIR35 = "/test-scenarios/single/scenario-decision-ir35.csv"

  "POST /decide" should {
    "return 200 and correct response with the expected undecided decision" in {
      createRequestSendVerifyDecision(TEST_CASE_UNKNOWN)
    }
    "return 200 and correct response with the expected out IR35 decision" in {
      createRequestSendVerifyDecision(TEST_CASE_OUTOFIR35)
    }
    "return 200 and correct response with the expected inside IR35 decision" in {
      createRequestSendVerifyDecision(TEST_CASE_INSIDEIR35)
    }
  }


}
