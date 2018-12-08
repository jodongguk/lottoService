package com.donggoos.lotto.model;

public class DrawDeserialize { //extends JsonDeserializer<Draw> {

/*
    private final ObjectMapper objectMapper;

    public DrawDeserialize() {
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public Draw deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {

        ObjectCodec objectCodec = jsonParser.getCodec();
        JsonNode jsonNode = objectCodec.readTree(jsonParser);

        final Long drawNo = jsonNode.get("drawNo").asLong();

        Draw draw = new Draw();
        draw.setDrawNo(drawNo);
        draw.setDrawDate(jsonNode.get("drawDate").asText());
        draw.setDrawDateYn(jsonNode.get("drawDateYn").asText());
        draw.setNum1(jsonNode.get("num1").asInt());
        draw.setNum2(jsonNode.get("num2").asInt());
        draw.setNum3(jsonNode.get("num3").asInt());
        draw.setNum4(jsonNode.get("num4").asInt());
        draw.setNum5(jsonNode.get("num5").asInt());
        draw.setNum6(jsonNode.get("num6").asInt());
        draw.setBonusNum(jsonNode.get("bonusNum").asInt());
        draw.setTotalSellingPrice(jsonNode.get("totalSellingPrice").asLong());


        List<LottoResult> lottoResults = new ArrayList<LottoResult>();
        for (JsonNode node : jsonNode.get("lottoResult")) {
            LottoResult lottoResult = new LottoResult();
            lottoResult.setId(new LottoResult.LottoResultId(drawNo, node.get("rank").asText()));
            lottoResult.setSellingPriceByRank(node.get("sellingPriceByRank").asText());
            lottoResult.setWinningPriceByRank(node.get("winningPriceByRank").asText());
            lottoResult.setWinningCnt(node.get("winningCnt").asText());

            lottoResults.add(lottoResult);
        }
        draw.setLottoResult(lottoResults);


        if(!jsonNode.get("winningPlaces").isNull()) {
            List<WinningPlace> winningPlaces = new ArrayList<WinningPlace>();
            for (JsonNode node : jsonNode.get("winningPlaces")) {
                WinningPlace winningPlace = new WinningPlace();
                winningPlace.setDrawNo(drawNo);
                winningPlace.setShopName(node.get("shopName").asText());
                winningPlace.setAddress(node.get("address").asText());
                winningPlace.setLat(node.get("lat").asText());
                winningPlace.setLng(node.get("lng").asText());
                winningPlace.setGameType(node.get("gameType").asText());

                winningPlaces.add(winningPlace);
            }
            draw.setWinningPlace(winningPlaces);
        }

        return draw;
    }*/
}