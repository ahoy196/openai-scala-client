package io.cequence.openaiscala.domain.settings

case class CreateChatCompletionSettings(
  // ID of the model to use. Currently, only gpt-3.5-turbo and gpt-3.5-turbo-0301 are supported.
  model: String,

  // What sampling temperature to use, between 0 and 2.
  // Higher values like 0.8 will make the output more random, while lower values like 0.2 will make it more focused and deterministic.
  // We generally recommend altering this or top_p but not both. Defaults to 1.
  temperature: Option[Double] = None,

  // An alternative to sampling with temperature, called nucleus sampling, where the model considers the results of the tokens with top_p probability mass.
  // So 0.1 means only the tokens comprising the top 10% probability mass are considered.
  // We generally recommend altering this or temperature but not both. Defaults to 1.
  top_p: Option[Double] = None,

  // How many chat completion choices to generate for each input message. Defaults to 1.
  n: Option[Int] = None,

//  stream

  // Up to 4 sequences where the API will stop generating further tokens.
  stop: Seq[String] = Nil, // Option[String or Array],

  // The maximum number of tokens allowed for the generated answer.
  // By default, the number of tokens the model can return will be (4096 - prompt tokens).
  max_tokens: Option[Int] = None,

  // Number between -2.0 and 2.0.
  // Positive values penalize new tokens based on whether they appear in the text so far,
  // increasing the model's likelihood to talk about new topics.
  // Defaults to 0.
  presence_penalty: Option[Double] = None,

  // Number between -2.0 and 2.0.
  // Positive values penalize new tokens based on their existing frequency in the text so far,
  // decreasing the model's likelihood to repeat the same line verbatim.
  // Defaults to 0.
  frequency_penalty: Option[Double] = None,

  // Modify the likelihood of specified tokens appearing in the completion.
  // Accepts a json object that maps tokens (specified by their token ID in the tokenizer) to an associated bias value from -100 to 100.
  // Mathematically, the bias is added to the logits generated by the model prior to sampling.
  // The exact effect will vary per model, but values between -1 and 1 should decrease or increase likelihood of selection;
  // values like -100 or 100 should result in a ban or exclusive selection of the relevant token.
  logit_bias: Map[String, Int] = Map(),

  // A unique identifier representing your end-user, which can help OpenAI to monitor and detect abuse.
  user: Option[String] = None
)
