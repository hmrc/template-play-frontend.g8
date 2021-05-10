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

import com.google.inject.Inject
import $package$.wiring.AppConfig
import play.api.i18n.{I18nSupport, Lang, MessagesApi}
import play.api.mvc._
import uk.gov.hmrc.play.bootstrap.frontend.controller.FrontendController
import scala.concurrent.Future
import $package$.views.$servicePrefixCamel$RouteOneViews
import $package$.models._
import play.api.data.Form
import play.api.data.Forms._

class $servicePrefixCamel$RouteOneController @Inject() (
  appConfig: AppConfig,
  override implicit val messagesApi: MessagesApi,
  controllerComponents: MessagesControllerComponents,
  views: $servicePrefixCamel$RouteOneViews
) extends FrontendController(controllerComponents) with I18nSupport {

  val start = Action.async { implicit request =>
    Future.successful(Ok(views.startPage()))
  }

}

object $servicePrefixCamel$RouteOneController {

  import FormFieldMappings._

  val DeclarationDetailsForm = Form[DeclarationDetails](
    mapping(
      "epu"         -> epuMapping,
      "entryNumber" -> entryNumberMapping,
      "entryDate"   -> entryDateMapping
    )(DeclarationDetails.apply)(DeclarationDetails.unapply)
  )

}
