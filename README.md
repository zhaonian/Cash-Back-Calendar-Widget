[![License](https://img.shields.io/badge/license-Apache%202-4EB1BA.svg?style=flat-square)](https://www.apache.org/licenses/LICENSE-2.0.html)
# Cash-Back-Calendar-Widget
an Android widget that pins the cash back calendars from various banks on your wall paper.

## How to modify the data source when creating updates?
1. Modify `CashbackDataSource.kt`
2. Modify `view_cards_selection.xml`
3. Modify `SharedPreferenceService`
4. Modify `fab.setOnClickListener` in `MainActivity.kt`
5. Modify `setCardCashbacks(curCard.cashbacks[ {currentQuarter} ])` in `CardRecyclerViewAdapter.kt`
<br/>
<p float="left">
  <img alt='showcase 1' src='./showcase1.png' width='230px'/>
  &nbsp &nbsp
  <img alt='showcase 2' src='./showcase2.png' width='230px'/>
</p>

<a href='https://play.google.com/store/apps/details?id=io.keyu.cashbackcalendarwidget&pcampaignid=MKT-Other-global-all-co-prtnr-py-PartBadge-Mar2515-1'><img alt='Get it on Google Play' src='https://play.google.com/intl/en_us/badges/images/generic/en_badge_web_generic.png' width='200px'/></a>
