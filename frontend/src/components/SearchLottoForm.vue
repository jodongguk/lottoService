<template>
    <div class="searchLottoForm">
        <b-form @submit="onSubmit">
            <b-input-group prepend="Draw Number">
                <b-form-input id="input1"
                              type="number"
                              v-model="form.drawNo"
                              required
                              placeholder="Enter Draw Number">
                </b-form-input>
                <b-input-group-append>
                    <b-btn variant="outline-success" type="submit">Search</b-btn>
                </b-input-group-append>
            </b-input-group>
        </b-form>

        <div class="lotto-num-deck" v-if="showResponse">
            <div class="lotto-num num1">{{ draw.num1 }}</div>
            <div class="lotto-num num2">{{ draw.num2 }}</div>
            <div class="lotto-num num3">{{ draw.num3 }}</div>
            <div class="lotto-num num4">{{ draw.num4 }}</div>
            <div class="lotto-num num5">{{ draw.num5 }}</div>
            <div class="lotto-num num6">{{ draw.num6 }}</div>
            <div class="lotto-num bonus">{{ draw.bonusNum }}</div>
        </div>

        <div v-if="showResponse">
            <GmapMap
                    :center="{lat:37.61921, lng:126.91977}"
                    :zoom="6"
                    map-type-id="terrain"
                    style="width: 500px; height: 300px"
            >
                <GmapMarker
                        :key="index"
                        v-for="(m, index) in draw.winningPlace"
                        :position="google && new google.maps.LatLng(m.lat, m.lng)"
                        :clickable="true"
                        :draggable="false"
                        @click="center=new google.maps.LatLng(m.lat, m.lng)"
                />
            </GmapMap>
        </div>
    </div>
</template>
<script>
    import {AXIOS} from './http-common'
    import {gmapApi} from 'vue2-google-maps'

    export default {
        name: 'searchLottoForm',
        data() {
            return {
                showResponse: false,
                errors: [],
                draw: {},
                form: {
                    drawNo: ''
                }
            }
        },
        methods: {
            onSubmit (evt) {
                evt.preventDefault();
                AXIOS.get(`/draw/` + this.form.drawNo)
                    .then(response => {
                        // JSON responses are automatically parsed.
                        console.log(response.data);

                        this.draw = response.data;
                        this.showResponse = true;
                    })
                    .catch(e => {
                        this.errors.push(e)
                    });
            }
        },
        computed: {
            google: gmapApi
        }
    }
</script>
<style>
    .lotto-num {
        text-align: center;
        display: inline-block;
        padding: 5px;
        margin: 0 5px;
        border-radius: 100%;
        color: #fff;
        width: 32px;
    }
    .lotto-num.num1 {background: #ffc100;}
    .lotto-num.num2 {background: #ffc100;}
    .lotto-num.num3 {background: #4dc9f2;}
    .lotto-num.num4 {background: #ff736e;}
    .lotto-num.num5 {background: #aaaaaa;}
    .lotto-num.num6 {background: #afd543;}
    .lotto-num.bonus {background: #aaaaaa; margin-left: 20px;}
</style>