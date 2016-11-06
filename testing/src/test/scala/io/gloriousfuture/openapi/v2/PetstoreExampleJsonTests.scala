package io.gloriousfuture.openapi.v2

import io.circe.Json
import org.scalatest.FreeSpec

class PetstoreExampleJsonTests extends FreeSpec with PetstoreExampleTests {

  override protected def loadPetstoreExample(): Json = PetstoreExample.asJson
}
