<template>
    <div id="main">
        <b-jumbotron header="Lotto Api" lead="SpringBoot + Vue" >
            <b-btn variant="primary" href="#">More Info</b-btn>
        </b-jumbotron>

        <SearchLottoForm></SearchLottoForm>
    </div>
</template>

<script>
    import SearchLottoForm from '@/components/SearchLottoForm.vue'

    export default {
        name: 'main',
        data() {
            return {
            }
        },
        components: {
            SearchLottoForm
        }
    }
</script>